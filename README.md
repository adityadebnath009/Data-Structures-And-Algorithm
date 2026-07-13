# Data Structures and Algorithms (DSA)

Welcome to my DSA repository! This project is dedicated to tracking my progress, practice, and solutions to various Data Structures and Algorithms problems.

## 📁 Repository Structure

```text
DSA/
├── LeetCode/            # LeetCode solutions organized by topic
│   ├── Array/           # Topic folder
│   │   └── P0001_TwoSum.java
│   └── LinkedList/
├── HackerRank/          # HackerRank solutions organized by topic
├── GeeksForGeeks/       # GeeksForGeeks solutions organized by topic
├── DataStructures/      # Custom Data Structure implementations from scratch
│   ├── Arrays/          # e.g., MyArrayList.java
│   └── LinkedList/      # e.g., SinglyLinkedList.java
├── new_problem.py       # Helper script to generate a Java solution
└── README.md
```

## 🚀 How to Add a New Problem

You can use the automation helper script to generate the Java file with the proper structure and class name:

1. Open your terminal in the workspace directory.
2. Run the script:
   ```bash
   python3 new_problem.py
   ```
3. Follow the interactive prompts to enter the platform (LeetCode, GFG, etc.), topic category, problem ID, problem name, and difficulty.
4. The script will generate:
   - A dedicated folder under the platform directory matching the topic/data structure category (e.g. `LeetCode/Array/`).
   - A `.java` file inside it with a Javadoc comment block at the top containing problem details, link, complexity, and approach.
   - A Java class skeleton matching the filename (e.g., `public class P0001_TwoSum`).
   - An appropriate package declaration (e.g. `package LeetCode.Array;`).

## 🛠️ Languages Used

- Java ☕️



