

public class FenwickTree{

    int value;
    int leftSize;
    FenwickTree left, right;
            
    public FenwickTree(int value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.leftSize = 0;            
    }
    
    public FenwickTree(int leftSize, FenwickTree left, FenwickTree right){
        this.left = left;
        this.right = right;
        this.value = left.value + right.value;
        this.leftSize = initLeftSize(this);
    }

    public static FenwickTree allZeros(int n) {
        if (n == 0) return null;
        if (n == 1) return new FenwickTree(0);
        int m = n / 2;
        return new FenwickTree(0, allZeros(n-m), allZeros(m));
    }

    public int size() {
        if (this.right == null && this.left == null) return 1;

        if (this.right == null) return leftSize;

        int leafs = leftSize;
        leafs += this.right.size();
        return leafs;
    }

    public void increment(int i, int delta) {
        if (i == 0 && left == null && right == null) {
                value += delta;
                return;
        }

        if (i < leftSize) {
            left.increment(i, delta);
        } else {
            right.increment((i-leftSize), delta);
        }
        value = left.value + right.value;
    }

    public int prefixSum(int upto) {
        if (upto == 0 && right == null && left == null) {
            return 0;
        }
        if (right == null && left == null) {
            return value;
        }

        if (upto >= leftSize) {
            return (value - right.value) + right.prefixSum(upto-leftSize);
        } else {
            return left.prefixSum(upto);
        }
    }

    public int between(int lo, int hi) {
        return prefixSum(hi) - prefixSum(lo);
    }
    
    private int initLeftSize(FenwickTree ftree){
        int leafs = 0;
        if(ftree.left != null) leafs += countLeafs(ftree.left);
        return leafs;
    }
    
    private int countLeafs(FenwickTree ftree){
        if(ftree.left == null && ftree.right == null) return 1;
        
        int cnt = 0;
        if(ftree.left != null) cnt += countLeafs(ftree.left);
        if(ftree.right != null) cnt += countLeafs(ftree.right);
        return cnt;
    }
    
    @Override
    public String toString(){
        String resultado = "[" + value + ", " + leftSize;
        if (this.left != null) resultado += (", " + this.left);
        if (this.right != null) resultado += (", " + this.right);
        resultado += "]";
        return resultado;
    }
}