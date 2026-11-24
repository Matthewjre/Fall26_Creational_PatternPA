# Fall 2026 Creational Patterns PA · Campus Event Desk

The campus event desk issues passes, prepares workshop kits, and plans events.
The demo works with direct constructor calls. Refactor each task so the code
that uses the products can work with the appropriate creational pattern.

## Read the code

| Exercise         | Start here                                                                     | What it creates                      |
|------------------|--------------------------------------------------------------------------------|--------------------------------------|
| Factory Method   | [Pass desk](src/main/java/edu/example/eventdesk/factorymethod/README.md)       | A day or weekend pass                |
| Abstract Factory | [Workshop desk](src/main/java/edu/example/eventdesk/abstractfactory/README.md) | A matching schedule and supply list  |
| Builder          | [Event planning](src/main/java/edu/example/eventdesk/builder/README.md)        | An event plan with optional settings |

## Demo

The sample shows what the event desk should display before and after your
refactorings.

```text
Pass for Avery | 1 day(s)
Pass for Jordan | 2 day(s)
Online workshop | Join the video call
Supplies | Headset, Worksheet
Welcome session | Union 210 | 40 seats
Projector: true | Refreshments: false
```
