password = 0
current = 50
prev = current

with open('inputs/1.input', 'r') as f:
    lines = f.read().split('\n')

for line in lines:
    if line[0] == 'L':
        current -= int(line[1:])

    elif line[0] == 'R':
        current += int(line[1:])

    if prev != 0 or int(line[1:]) >= 100:
        password += abs(current // 100)
        if prev == 0 and int(line[1:]) > 100 and line[0] == 'L':
            password -= 1

    if current <= 0 and current % 100 == 0:
        password += 1

    current = current % 100
    prev = current

print(password)