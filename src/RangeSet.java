import java.util.*;

public class RangeSet implements Set<Integer> {
    private static final Set<Integer> integerSet = new HashSet();
    private static final Set<Integer> rangeSet = new HashSet();


    public void addRange(int from, int to) {
        ArrayList<Integer> list = new ArrayList(rangeSet);

        for (int i = 0; i < list.size(); i = i + 2) {
            if ((list.get(i) < from && from < list.get(i + 1))) {
                if (!(list.get(i) < to && to < list.get(i + 1))) {
                    list.add(to);
                }
                break;
            }
            if ((list.get(i) < to && to < list.get(i + 1))) {
                if (!(list.get(i) < from && from < list.get(i + 1))) {
                    list.add(from);
                }
                break;
            } else {
                list.add(to);
                list.add(from);
            }
            break;


        }
        for (int i = 0; i < list.size(); i++) {
            if (from < list.get(i) && list.get(i) < to) {
                list.remove(list.get(i));
            }
        }

        if (list.size() == 0) {
            list.add(to);
            list.add(from);
        }


        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 1; j < list.size(); j++) {
                if (i != j && list.get(i) == list.get(j)) {
                    list.remove(list.get(i));
                    list.remove(list.get(j));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            rangeSet.add(list.get(i));
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
