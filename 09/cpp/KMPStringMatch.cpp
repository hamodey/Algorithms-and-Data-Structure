#include "KMPStringMatch.hpp"

void KMPStringMatch::computePrefix(std::string P) {
  size_t m = P.size();
  if(m == 0) return;
  pi = new int[m];
  pi[0] = 0;
  int k = 0;
  for(int q = 1; q < m; q++) {
    while(k > 0 && (counter.add(2), P[k] != P[q])) {
      k = pi[k-1];
    }
    counter.add(2);
    if(P[k] == P[q]) k++;
    pi[q] = k;
  }
}

size_t KMPStringMatch::match(std::string text, std::string pattern) {
  size_t n = text.size();
  size_t m = pattern.size();
  computePrefix(pattern);
  if(m == 0) return 0;
  if(n == 0) return -1;
  int q = 0;
  for(int i = 0; i < n; i++) {
    while(q > 0 && (counter.add(2), pattern[q] != text[i])) {
      q = pi[q-1];
    }
    counter.add(2);
    if(pattern[q] == text[i]) q++;
    if(q == m) return i - m + 1;
  }
  return -1;
}
