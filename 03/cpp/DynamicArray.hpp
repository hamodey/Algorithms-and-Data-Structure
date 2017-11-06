#ifndef DYNAMICARRAY_HPP
#define DYNAMICARRAY_HPP

#include <cstddef>

#include "OpCounter.hpp"

class DynamicArray {
public:
  OpCounter counter = OpCounter();
public:
  DynamicArray(size_t);
  size_t length();
  int select(size_t);
  void store(int, size_t);
  void push(int);
  int pop();
private:
  void extend();
};

#endif
