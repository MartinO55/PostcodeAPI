# Postcode API

## Summary

This exercise is designed to demonstrate your abilities in developing a
backend Java Spring service.

The source code, comments, documentation and architecture are all part
of how we will evaluate your solution.

The problem can be solved many ways with no right or wrong answer. Just
show us how you typically work. Let us know if you are not able to finish.
Just explain what was remaining to do

## Problem

- We want you to create an API in Java that allows mobile clients to
  retrieve and add suburb and postcode combinations. You do not have
  to write the mobile app!
- We want you to implement:

  - An API that allows mobile clients to retrieve the suburb information by postcode.
  - An API that allows mobile clients to retrieve a postcode given a suburb name

- A secured API to add new suburb and postcode combinations (you'll have to work out how this should work)
- Some form of persistence (a database)
- Testing for controller / service layers

## Design Considerations

    - The First problem with this is that there is no single return for either of these. Postcodes can have many suburbs and suburbs can have multiple postcodes. AND some suburbs have no postcode.
    - This makes this really annoying: you can have a list of suburbs and their postcodes, but you repeat postcodes (or have null postcodes). And you repeat suburbs. If you have a list of postcodes, you lose suburbs, or you have the same postcode like 6 times.

    So to not break every rule of database design, you have to do a join table. I have no clue how to do this, so this will be FUN.

    So best option is probably to accept duplicate postcodes, and to store postcode as a string? but if its updateable by users then... no delete, miss spellings, you will have duplicates anyway. And postcode has to be a string because of the Pommes

- Best Practice
  - Develop with current best practice
  - Design patterns, software architecture, secure coding
  - Libraries, industry standards
- Reusability
  - Is there anything that can be reused in future projects?
- Support knowledge sharing
  - Documentation
  - Comments
  - Anything can help with knowledge sharing with the technical team
- Development Process and Quality Control
  - Testing
