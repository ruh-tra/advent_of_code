password = 0

current = 50

with open('2025/inputs/1.input', 'r') as f:
    lines = f.read().split('\n')

for line in lines:
    if line[0] == 'L':
        current = (current - int(line[1:])) % 100
    else:
        current = (current + int(line[1:])) % 100
    
    if current == 0:
        password += 1

print(password)