with open('.inputs/4.input', 'r') as f:
    lines = f.read().split('\n')

grid = [['.' for _ in range(141)] for _ in range(141)]
accessible = 0

for col, line in enumerate(lines):
    for row, _ in enumerate(line):
        grid[col + 1][row + 1] = lines[col][row]

for col_idx, col in enumerate(grid[1:-1]):
    for row_idx, char in enumerate(col[1:-1]):
            adj = 0
            for d_col in range(-1, 2):
                for d_row in range(-1, 2):
                    if grid[col_idx + d_col + 1][row_idx + d_row + 1] in ('@', 'x'):
                        adj += 1

            if adj < 5 and char == '@':
                grid[col_idx + 1][row_idx + 1] = 'x'
                accessible += 1

for line in grid:
    print(''.join(line))

print(accessible)