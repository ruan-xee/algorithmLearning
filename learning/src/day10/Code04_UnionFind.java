package day10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code04_UnionFind {
    // 对value进行一层包装
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V v : list) {
                Element<V> element = new Element<>(v);
                elementMap.put(v, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element<V> findhead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (fatherMap.get(element) != element) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findhead(elementMap.get(a)) == findhead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findhead(elementMap.get(a));
                Element<V> bF = findhead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = sizeMap.get(aF) > sizeMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                    sizeMap.remove(small);
                }
            }
        }
    }


}
