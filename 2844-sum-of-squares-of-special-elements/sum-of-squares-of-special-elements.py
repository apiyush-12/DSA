class Solution:
    def sumOfSquares(self, nums: List[int]) -> int:
        n = len(nums)
        total = 0
        i=1
        for num in nums:
            if n % i == 0:
                total += num*num
            i = i+1
        return total