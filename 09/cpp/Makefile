include ../../cpp.mk

StringMatchTest: StringMatchTest.o StringMatch.o NaiveStringMatch.o RKStringMatch.o KMPStringMatch.o ../../00/cpp/OpCounter.o
	$(CC) $(CFLAGS) $(CPPFLAGS) $(LDFLAGS) $(TARGET_ARCH) $^ $(LOADLIBES) $(LDLIBS) -o $@

test: StringMatchTest
	./StringMatchTest NaiveStringMatch

StringMatchCount: StringMatchCount.o StringMatch.o NaiveStringMatch.o RKStringMatch.o KMPStringMatch.o ../../00/cpp/OpCounter.o
	$(CC) $(CFLAGS) $(CPPFLAGS) $(LDFLAGS) $(TARGET_ARCH) $^ $(LOADLIBES) $(LDLIBS) -o $@

.PHONY: test
