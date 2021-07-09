# Nozemi's OSRS
This is a OSRS base heavily influenced by OS-Scape source code. I've tried to retain the classes author comments for code that is a copy of OSS code.

### **Goals for this project are:**
1. Making it less coupled\
   1.1. Implementing Spring (without the web server for now) to leverage it's dependency injection\
   1.2. Also leveraging Spring for data loading, because it's very easy to switch database technology
2. Getting rid of Quasar\
   2.1 Wondering if I can use Kotlin naitvely instead.
   
### Supported Data Storage
#### Characters
- SQLite
- PostgreSQL
- JSON (flatfile)

#### NPC Spawns
- SQLIte
- PostgreSQL
- JSON (flatfile)

_Need to update this readme later... For now the information isn't all accurate_