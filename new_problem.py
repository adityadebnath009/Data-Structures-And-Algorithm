import os
import sys
import re

def to_camel_case(text):
    # Keep alphanumeric characters and capitalize each word
    words = re.sub(r'[^a-zA-Z0-9\s]', ' ', text).split()
    return "".join(word.capitalize() for word in words)

def create_problem():
    print("🚀 Java DSA File Generator")
    print("-------------------------")
    
    # 1. Select Platform / Category
    platforms = ["LeetCode", "HackerRank", "GeeksForGeeks", "DataStructures", "Other"]
    print("Select Category/Platform:")
    for idx, p in enumerate(platforms, 1):
        print(f"  {idx}. {p}")
    
    platform_choice = input("Enter choice (default 1): ").strip()
    platform = platforms[int(platform_choice) - 1] if platform_choice.isdigit() and 1 <= int(platform_choice) <= len(platforms) else platforms[0]

    # Handle DataStructures Category
    if platform == "DataStructures":
        # Select Data Structure Subfolder
        subfolders = ["Arrays", "LinkedList", "Trees", "Graphs"]
        print("\nSelect Data Structure Subfolder:")
        for idx, sf in enumerate(subfolders, 1):
            print(f"  {idx}. {sf}")
        print("  5. Custom (Type a custom folder name)")
        
        sf_choice = input("Enter choice (default 1): ").strip()
        if sf_choice == "5":
            subfolder = input("Enter custom subfolder name: ").strip()
            subfolder = to_camel_case(subfolder)
        else:
            subfolder = subfolders[int(sf_choice) - 1] if sf_choice.isdigit() and 1 <= int(sf_choice) <= len(subfolders) else subfolders[0]
            
        class_name = input("Enter Class Name (e.g., DoublyLinkedList): ").strip()
        class_name = to_camel_case(class_name)
        
        # Package and java content template for DataStructures
        java_content = f"""package DataStructures.{subfolder};

/**
 * Custom implementation of {class_name} from scratch.
 * 
 * Time Complexities:
 * - Insertion: O(1)
 * - Deletion: O(1)
 * - Access/Search: O(N)
 */
public class {class_name} {{
    
    public {class_name}() {{
        // TODO: Initialize your data structure here
    }}

    public static void main(String[] args) {{
        System.out.println("Running {class_name}...");
        // Write test cases here
    }}
}}
"""
        target_dir = os.path.join("DataStructures", subfolder)
        os.makedirs(target_dir, exist_ok=True)
        file_path = os.path.join(target_dir, f"{class_name}.java")
        
        if not os.path.exists(file_path):
            with open(file_path, "w") as f:
                f.write(java_content)
            print(f"\n✅ Created Java custom Data Structure: {file_path}")
            print(f"👉 Package: package DataStructures.{subfolder};")
            print(f"👉 Class name matches filename: public class {class_name}")
        else:
            print(f"\n⚠️ File already exists at: {file_path}")

    # Handle standard problem solving platform (LeetCode, HackerRank, etc.)
    else:
        # 2. Problem details
        prob_id = input("\nEnter Problem ID / Number (e.g., 1): ").strip()
        prob_name = input("Enter Problem Name (e.g., Two Sum): ").strip()
        
        # 3. Select Difficulty
        difficulties = ["Easy", "Medium", "Hard"]
        print("Select Difficulty:")
        for idx, d in enumerate(difficulties, 1):
            print(f"  {idx}. {d}")
        diff_choice = input("Enter choice (default 1): ").strip()
        difficulty = difficulties[int(diff_choice) - 1] if diff_choice.isdigit() and 1 <= int(diff_choice) <= len(difficulties) else difficulties[0]

        # 4. Generate Java class name and file name
        camel_name = to_camel_case(prob_name)
        if prob_id.isdigit():
            class_name = f"P{int(prob_id):04d}_{camel_name}"
        else:
            class_name = f"P_{to_camel_case(prob_id)}_{camel_name}"
            
        formatted_name = prob_name.lower().replace(" ", "-")
        problem_url = f"https://leetcode.com/problems/{formatted_name}/" if platform == "LeetCode" else "Link to problem"

        # 5. Define Java content template with Javadoc comments
        java_content = f"""/**
 * Platform: {platform}
 * Problem ID: {prob_id}
 * Problem Name: {prob_name}
 * Difficulty: {difficulty}
 * 
 * Link: {problem_url}
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class {class_name} {{
    public static void main(String[] args) {{
        // Write test cases here
        System.out.println("Running {class_name}...");
    }}

    // TODO: Write solution method here
}}
"""

        # 6. Ensure target directory exists and write file
        target_dir = platform
        os.makedirs(target_dir, exist_ok=True)
        
        file_path = os.path.join(target_dir, f"{class_name}.java")
        
        if not os.path.exists(file_path):
            with open(file_path, "w") as f:
                f.write(java_content)
            print(f"\n✅ Created Java file: {file_path}")
            print(f"👉 Class name matches filename: public class {class_name}")
        else:
            print(f"\n⚠️ File already exists at: {file_path}")

if __name__ == "__main__":
    try:
        create_problem()
    except KeyboardInterrupt:
        print("\nExiting script...")
        sys.exit(0)
