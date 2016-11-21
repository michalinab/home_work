
public class Range {
    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void changeEnd(int newEnd) {
        this.end = newEnd;
    }

    public void changeStart(int newStart) {
        this.start = newStart;
    }

    public boolean contains(int i) {
        return start <= i & i <= end;
    }

}
