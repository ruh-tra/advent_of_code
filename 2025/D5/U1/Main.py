class ID_range():
    def __init__(self):
        self.ranges = []
    
    def append(self, other):
        self.ranges.append(other)

        for _ in range(2):
            for idx, r1 in enumerate(self.ranges):
                for r2 in self.ranges[idx + 1:]:
                    (l1, h1), (l2, h2) = r1, r2

                    if l1 <= l2 <= h1 or l2 <= l1 <= h2:
                        self.ranges.remove(r1)
                        self.ranges.remove(r2)
                        self.ranges.append((min(l1, l2), max(h1, h2)))

    def __contains__(self, e):
        for r in self.ranges:
            l, h = r

            if l <= e <= h:
                return True
            
        return False
    
fresh = 0

id_range = ID_range()

with open('inputs/5.input', 'r') as f:
    ranges, ids = [data.strip().split('\n') for data in f.read().split('\n\n')]

for r in ranges:
    lower, higher = r.split('-')
    id_range.append((int(lower), int(higher)))

for i in ids:
    if int(i) in id_range:
        fresh += 1

print(fresh)