Biblioteca
==========

Comments and retrospectives (Part 1):
----------------------------

Looking back I feel I started this project on the wrong foot. The aim of the project was to satisfy the business requirements. In doing so I should have tried to write as little code as possible. It started well with the Book classes, but when it came to the UI, I became too focused on trying to implement it in a way that I thought would prove less brittle in the long run. I think this may have been my first mistake. 

What could have been a few simple loops and Sysout calls, turned into a small UI framework (which made testing difficult), and is a little overengineered for a small console application. It was around here I started to diverge slightly from TDD. Pair programming would have been really beneficial here, to stop getting tunnel vision.

In retrospect, I should have tried to implement the simplest possible UI code that worked, along with a good solid set of tests, instead of trying to plan ahead for an imaginary requirement (declarative UI building).

I'd love to hear your thoughts.


Comments and retrospectives (Part 2):
-------------------------------------

Taking the feedback Rick gave me I tried to integrate a more TDD approach into my design. No code was written under src without a test completed first. I strived to be as judicious as possible with my adherence and I think it paid off. My test coverage is 100% according to Emma (plugin), and the granularity is very small (i.e. testing only small bits at a time). Much better than the first assignment.

Again the UI layer proved to be a pain and I regret it. Unfortunately a rewrite wouldn't be viable at this stage. 

I also spent some time cleaning up the issues identified by Rick in the first part (unused code, redundant exceptions etc, poorly named exceptions etc).