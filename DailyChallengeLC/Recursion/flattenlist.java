/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> flatten;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        flatten = new ArrayList<>();
        index=0;
        flatten = f(nestedList);
    }

    public List<Integer> f(List<NestedInteger> nestedList){
        List<Integer> ans = new ArrayList<>();
        for(NestedInteger k : nestedList){
            if(k.isInteger()){
                ans.add(k.getInteger());
            }else{
                ans.addAll(f(k.getList()));
            }
        }
        return ans;
    }

    @Override
    public Integer next() {
        return flatten.get(index++);
    }

    @Override
    public boolean hasNext() {
       return index < flatten.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
