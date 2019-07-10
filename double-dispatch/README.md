# Double Dispatch

## General
This is a pattern that allows calling a concrete implementation using a general type
without the need of `instanceof`.

## GO example
We have two abstractions: `Operations` and `Commands`.
Each incoming `Operation` creates a `Command`, which is put into queue.
When the command is being processed, it's `action` methid is called.

### creteCommand method in Operation interface
Implementation in every class of Operation. Operation is a DTO - it must
not have any logic for creating commands.

### create a base class that calls the proper implementation
This does not work in Java - types in function call are selected at
compile time. You end up with `Operation` type.

## GOF Visitor pattern

The Visitor pattern is a specific version of DD. Where it differs is
that it is applied to a collection type: (a list or a tree) - the
Visitor does the computing and has a state.

Examples:
- traverse a list of shapes and sum their areas
- traverse an abstract syntax tree and generate code
