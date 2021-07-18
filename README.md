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

### Setting Up Project
1. Ideally you have an SSH key setup with your Github account. \
if not, you can [click here](https://docs.github.com/en/github/authenticating-to-github/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent) to read about how you do that.
2. When you have your SSH key setup, you can click the green "Code" button above the repository. \
This will show you a popup dialogue with some options. I recommend SSH, so copy the SSH url.
3. Open your preferred IDE (I would personally recommend [IntelliJ](https://www.jetbrains.com/idea/download/), get the community edition if you don't already have IntelliJ.).
4. In IntelliJ, you need to find the option to check out/get from VCS. If you have a project open already, it should be under *File -> New -> Project From Version Control...*
5. Once it has downloaded, just open it, and let the Gradle stuff import. If it doesn't detect the Gradle project automatically, you need to right-click `build.gradle.kts` and click *Import Gradle Project*
6. For `game-client` you will likely have to manually import the Gradle project. See step 5 for explanation if not sure.
7. Make sure you have a server.conf in your data folder, look at the [example config](/data/server.conf.example) for an example.
8. You need to download the cache. You can use the default OSS cache. [Click here](https://cdn.discordapp.com/attachments/861299604326973460/863868136997519380/cache.zip) to download.
9. You should now be able to launch the server and client. First launch the server. You can find the Gradle tab to the right in IntelliJ. Under `dodian-osrs` (game server), you find *Tasks -> application -> bootRun*, double click that. Then you find `dodian-osrs-client` (game client), you find *Tasks -> application -> run*.
10. Make sure to read the [guidelines](/CONTRIBUTE.md) on how to contribute to the project before you submit your pull requests.

### Credits
- [Situations](https://www.rune-server.ee/members/situations/)
- [Velocity](https://www.rune-server.ee/members/velocity/)
- [Savions](https://www.rune-server.ee/members/savions/)
- [Shadowy](https://www.rune-server.ee/members/shadowy/) \
^ 4 above are the original developers of [OS-S](https://www.rune-server.ee/runescape-development/rs2-server/downloads/697645-os-scape-171-server.html).
- Me ([Nozemi](https://www.rune-server.ee/members/nozemi/))
- [uint32_t](https://www.rune-server.ee/members/uint32_t/) - For consulting and bearing with me while I complain about things I fuck up.
- [JayArrowz](https://www.rune-server.ee/members/jayarrowz/) - For consulting about proper ways to implement things.