# 动态规划

通过题意，可以理解为最优解问题，考虑是否可以使用动态规划。
1. 符合最优子结构，若我抢 ```i``` 个房子，则它是 ```dp[i-2]```和 
```dp[i-3]```最优解 ```+ rob[i]``` 。
2. 符合无后性
3. 若用穷举则有重复计算的可能性

## 转移方程

```
dp[i] = Math.max(dp[i-2],dp[i-3])+rob[i]
```

定义为 ： 若抢第i个房子的最大值

则 return 为

```
int max =0
for(int i=0;i<length;i++)
   max= Math.max(max,dp[i]);
return max;
```