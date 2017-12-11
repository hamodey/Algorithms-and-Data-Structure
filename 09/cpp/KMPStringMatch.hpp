#ifndef KMPSTRINGMATCH_HPP
#define KMPSTRINGMATCH_HPP

#include "StringMatch.hpp"

class KMPStringMatch : public StringMatch {
private:
  int* pi;
  void computePrefix(std::string);
public:
  size_t match(std::string, std::string) override;
};

#endif
