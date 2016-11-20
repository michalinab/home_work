import java.util.*;

public class RangeSet implements Set<Integer> {

    private static Set<Integer> integerSet = new HashSet();
    private static Set<Integer> rangeSet = new HashSet();

    public void addRange(int from, int to) {
        ArrayList<Integer> rangeList = new ArrayList<>(rangeSet);
        Collections.sort(rangeList);


        if (rangeList.isEmpty()) {
            rangeSet.add(from);
            rangeSet.add(to);
        } else {

            if (rangeSet.contains(from) || rangeSet.contains(to)) {


                this.rangeSet = new HashSet<>(rangeList.size());

                for (int i = 0; i < rangeList.size() - 1; i = i + 2) {
                    int current = rangeList.get(i);
                    int next = rangeList.get(i + 1);

                    if (!(current <= from & from <= next)) {

                        current = from;

                        if (!(current <= from & from <= next)) {

                            next = to;
                        }


                    }
                    for (int j = 0; j < rangeList.size(); j++) {
                        rangeSet.add(rangeList.get(j));
                    }

                }
            } else {
                rangeSet.add(from);
                rangeSet.add(to);
            }
        }
    }

    @Override
    public int size() {

        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        ArrayList<Integer> integerList = new ArrayList<>(integerSet);
        ArrayList<Integer> rangeList = new ArrayList<>(rangeSet);
        Collections.sort(integerList);
        Collections.sort(rangeList);

        for (int i = 0; i < rangeList.size(); i = i + 2) {
            if (rangeList.get(i) <= (int) o && (int) o <= rangeList.get(i + 1)) {
                return true;
            }
        }

        for (int j = 0; j < integerList.size(); j++) {
            if (integerList.get(j) == (int) o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        integerSet.add(integer);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        rangeSet.add((int) o - 1);
        rangeSet.add((int) o + 1);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

}
