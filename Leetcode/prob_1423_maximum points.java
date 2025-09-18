class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0,rsum=0,maxsum=0;
        for(int i=0;i<k;i++)
        {
            lsum+=cardPoints[i];
        }
        maxsum=lsum;
        int n=cardPoints.length;
        int rind=n - 1;
        for(int i=k-1;i>=0;i--)
        {
            lsum=lsum-cardPoints[i];
            rsum=rsum+cardPoints[rind];
            rind=rind-1;
            maxsum=Math.max(maxsum,lsum+rsum);
        }
        return maxsum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;

        int result = sol.maxScore(cardPoints, k);
        System.out.println("Maximum Score: " + result);
    }
}
