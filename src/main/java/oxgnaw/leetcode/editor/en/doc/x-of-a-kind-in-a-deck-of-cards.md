[TOC]

## Solution
---
#### Approach 1: Brute Force

**Intuition**

We can try every possible `X`.  

**Algorithm**

Since we divide the deck of `N` cards into say, `K` piles of `X` cards each, we must have `N % X == 0`.

Then, say the deck has `C_i` copies of cards with number `i`.  Each group with number `i` has `X` copies, so we must have `C_i % X == 0`.  These are necessary and sufficient conditions.

```
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        List<Integer> values = new ArrayList();
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0)
                values.add(count[i]);

        search: for (int X = 2; X <= N; ++X)
            if (N % X == 0) {
                for (int v: values)
                    if (v % X != 0)
                        continue search;
                return true;
            }

        return false;
    }
}
```

**Complexity Analysis**

* Time Complexity:  ![O(N^2\log\logN) ](./p__O_N^2_log_log_N__.png) , where *N* is the number of cards.  It is outside the scope of this article to prove that the number of divisors of *N* is bounded by ![O(N\log\logN) ](./p__O_N_log_log_N__.png) .

* Space Complexity:  *O(N)*.
<br />
<br />


---
#### Approach 2: Greatest Common Divisor

**Intuition and Algorithm**

Again, say there are `C_i` cards of number `i`.  These must be broken down into piles of `X` cards each, ie. `C_i % X == 0` for all `i`.

Thus, `X` must divide the greatest common divisor of `C_i`.  If this greatest common divisor `g` is greater than `1`, then `X = g` will satisfy.  Otherwise, it won't.

```
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
```

**Complexity Analysis**

* Time Complexity:  ![O(N\log^2N) ](./p__O_N_log^2_N__.png) , where *N* is the number of votes.  If there are *C_i* cards with number *i*, then each `gcd` operation is naively ![O(\log^2C_i) ](./p__O_log^2_C_i__.png) .  Better bounds exist, but are outside the scope of this article to develop.

* Space Complexity:  *O(N)*.
<br />
<br />