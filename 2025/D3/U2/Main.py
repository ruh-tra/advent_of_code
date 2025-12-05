with open('inputs/3.input', 'r') as f:
    lines = f.read().strip().split('\n')

joltage = 0
n = 12

for line in lines:
    for k in range(-n + 1, 1):
        joltage += int(max(line[:len(line) + k])) * 10 ** (-k)
        line = line[line.index(max(line[:len(line) + k])) + 1:]

print(joltage)