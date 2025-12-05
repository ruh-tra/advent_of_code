with open('2025/inputs/3.input', 'r') as f:
    lines = f.read().strip().split('\n')

joltage = 0

for line in lines:
    joltage += int(max(line[:-1]) + max(line[line.index(max(line[:-1])) + 1:]))

print(joltage)