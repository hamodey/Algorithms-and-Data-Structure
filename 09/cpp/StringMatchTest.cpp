#include <cppunit/extensions/HelperMacros.h>
#include <cppunit/CompilerOutputter.h>
#include <cppunit/extensions/TestFactoryRegistry.h>
#include <cppunit/ui/text/TestRunner.h>

#include <fstream>

#include "StringMatch.hpp"
#include "NaiveStringMatch.hpp"
#include "RKStringMatch.hpp"
#include "KMPStringMatch.hpp"

// FIXME: this should be a member variable of the test class
static StringMatch *matcher;

class StringMatchTest : public CppUnit::TestFixture {
  CPPUNIT_TEST_SUITE(StringMatchTest);
  CPPUNIT_TEST(testZeroPattern);
  CPPUNIT_TEST(testZeroText);
  CPPUNIT_TEST(testTable);
  CPPUNIT_TEST_SUITE_END();
public:
  void setUp() {};
  void tearDown() {};
  void testZeroPattern();
  void testZeroText();
  void testTable();
};

void StringMatchTest::testZeroPattern() {
  CPPUNIT_ASSERT_EQUAL(0UL, matcher->match("abcde", ""));
}

void StringMatchTest::testZeroText() {
  CPPUNIT_ASSERT_EQUAL(-1UL, matcher->match("", "abcde"));
  CPPUNIT_ASSERT_EQUAL(0UL, matcher->match("", ""));
}

void StringMatchTest::testTable() {
  std::ifstream in("../match.txt");
  std::string text, pattern;
  int pos;
  std::string line;
  while (std::getline(in, line)) {
    std::istringstream is(line);
    is >> text >> pattern >> pos;
    if ((size_t) pos != matcher->match(text, pattern))
      CPPUNIT_FAIL(line);
  }
}

CPPUNIT_TEST_SUITE_NAMED_REGISTRATION(StringMatchTest, "StringMatch");
CPPUNIT_REGISTRY_ADD_TO_DEFAULT("StringMatch");

// FIXME: not the same boilerplate but still very similar
int main(int argc, char *argv[]) {
  if (argc != 2) {
    std::cerr << "Usage: " << argv[0] << " classname" << std::endl;
    return 1;
  }
  CppUnit::Test *test = CppUnit::TestFactoryRegistry::getRegistry().makeTest();;
  CppUnit::TextUi::TestRunner runner;
  runner.addTest(test);
  runner.setOutputter(new CppUnit::CompilerOutputter(&runner.result(), std::cerr));

  if(!strcmp(argv[1], "NaiveStringMatch")) {
    matcher = new NaiveStringMatch();
  } else if(!strcmp(argv[1], "RKStringMatch")) {
    matcher = new RKStringMatch();
  } else if(!strcmp(argv[1], "KMPStringMatch")) {
    matcher = new KMPStringMatch();
  } else {
    std::cerr << "Class " << argv[1] << " not recognized" << std::endl;
    return 1;
  }
  
  bool wasSuccessful = runner.run();
  return wasSuccessful ? 0 : 1;

}
