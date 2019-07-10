# Chain of Resposibility

## General
Several handlers with same interface arranged in a chain. It's
explicitly stated how the processing is done.

The code should be better structured and easier to read. Each handler is
independent.

## RGS example
The registration process is composed of multiple phases:
1. Lock ASDID
1. Check if model is allowed
1. Verify with licence
1. Change configuration
1. Update in db
1. Send refreshing and responses

Every stage uses external actors. The actor works as a FSM, but each
state is independent.

## Other examples
- Servlet filters

This pattern is similar to the Decorator (Wrapper) pattern. Decorator is
about adding functionality when Chain is about having multiple handlers.

This pattern is also similar to State pattern. State is about handling
the same data in a different way. Handling can occur in any moment. In
CoR the next state is invoked by the previous one.

