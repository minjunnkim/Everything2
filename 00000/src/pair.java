static class pair implements Comparable<pair>{
    
    int a, b;
    pair(int c, int d){
        a=c;
        b=d;
    }
    @Override
    public int compareTo(pair o) {
        
        return this.a-o.a;
    }

    public String toString() {
        return a+" "+b;
    }
}