import os

BASE_DIR = "src/main/java/dsa/exercises"

TOPICS = {
    "arrays": "Arrays",
    "strings": "Strings",
    "linkedlists": "Linked Lists",
    "stacks_queues": "Stacks & Queues",
    "trees_graphs": "Trees & Graphs",
    "recursion": "Recursion",
    "dynamic_programming": "Dynamic Programming"
}

def count_problems():
    counts = {}
    for folder, name in TOPICS.items():
        path = os.path.join(BASE_DIR, folder)
        count = 0
        if os.path.exists(path):
            for filename in os.listdir(path):
                if filename.endswith(".java"):
                    filepath = os.path.join(path, filename)
                    with open(filepath, "r", encoding="utf-8") as f:
                        content = f.read()
                        if "@exercise" in content:
                            count += 1
        counts[name] = count
    return counts

def generate_table(counts):
    lines = []
    lines.append("| Topic                | Problems |")
    lines.append("|---------------------|----------|")

    for topic, count in counts.items():
        lines.append(f"| {topic} | {count} |")

    return "\n".join(lines)

def update_readme(table):
    with open("README.md", "r", encoding="utf-8") as f:
        content = f.read()

    start = "<!-- START_PROGRESS -->"
    end = "<!-- END_PROGRESS -->"

    before = content.split(start)[0]
    after = content.split(end)[1]

    new_content = f"{before}{start}\n{table}\n{end}{after}"

    with open("README.md", "w", encoding="utf-8") as f:
        f.write(new_content)

if __name__ == "__main__":
    counts = count_problems()
    table = generate_table(counts)
    update_readme(table)