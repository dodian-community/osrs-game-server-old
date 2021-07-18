[![Discord](https://discordapp.com/api/guilds/169851018413211648/widget.png)](https://discord.gg/r4M6cSBdrT)

# Dodian OSRS
This is a OSRS base heavily influenced by [OS-Scape](https://www.rune-server.ee/runescape-development/rs2-server/downloads/697645-os-scape-171-server.html) source code. I've tried to retain the classes author comments for code that is a copy of OSS code.

**What's different here vs original [OS-S](https://www.rune-server.ee/runescape-development/rs2-server/downloads/697645-os-scape-171-server.html)?** \
Created a blank Spring-based project, with web server disabled (we don't need it, at least not yet). Then code related to networking, logging in etc was copied over from [OS-S](https://www.rune-server.ee/runescape-development/rs2-server/downloads/697645-os-scape-171-server.html). This essentially gave us a blank base without [Quasar](https://docs.paralleluniverse.co/quasar/). Once that was done, the process of reimplementing necessary fundamental core functionality (like Redis, serializer, command system, etc) was started.

**What's the goal of this project?** \
The project aims to use as much of [OS-S](https://www.rune-server.ee/runescape-development/rs2-server/downloads/697645-os-scape-171-server.html) original code as possible. However, eliminating the Quasar library and implementing Spring framework to leverage its dependency injection. Possibly also web server to serve real time data from the server from REST APIs.

The goal is then to create an okay base to start piecing together a [Dodian](https://dodian.net/) remake. There is currently a server for [Dodian](https://dodian.net/), however it's awfully bugged and is a nightmare to maintain in just about any way.

### Information
- [Example server config](/data/server.conf.example)

### Credits
- [Situations](https://www.rune-server.ee/members/situations/)
- [Velocity](https://www.rune-server.ee/members/velocity/)
- [Savions](https://www.rune-server.ee/members/savions/)
- [Shadowy](https://www.rune-server.ee/members/shadowy/) \
^ 4 above are the original developers of [OS-S](https://www.rune-server.ee/runescape-development/rs2-server/downloads/697645-os-scape-171-server.html).
- Me ([Nozemi](https://www.rune-server.ee/members/nozemi/))
- [uint32_t](https://www.rune-server.ee/members/uint32_t/) - For consulting and bearing with me while I complain about things I fuck up.
- [JayArrowz](https://www.rune-server.ee/members/jayarrowz/) - For consulting about proper ways to implement things.