#include <iostream>

#include "StringMatch.hpp"
#include "NaiveStringMatch.hpp"
#include "RKStringMatch.hpp"
#include "KMPStringMatch.hpp"

int main() {
  std::string P = "ab";
  std::string T = "aaaaaaaaaa";
  StringMatch *matcher = new NaiveStringMatch();

  matcher->match(T, P);
  std::cout << "char reads: " << matcher->counter.report() << std::endl;;

  delete matcher;
  return 0;
}
