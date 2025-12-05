class ID_range():
    def __init__(self):
        self.ranges = set()
    
    def append(self, e):        
        overlapping = {e}

        self.ranges.add(e)

        while overlapping:
            temp = set()
            for o in list(overlapping):
                l1, h1 = o
                for r in list(self.ranges):
                    l2, h2 = r

                    if (l1 <= h2 <= h1 or l1 <= l2 <= h1 or \
                        l2 <= l1 <= h2 or l2 <= h1 <= h2) and \
                        o != r:
                        n = ((min(l1, l2), max(h1, h2)))
                        self.ranges.discard(r)
                        self.ranges.add(n)
                        temp.add(n)

            overlapping = temp

    def __contains__(self, e):
        for r in self.ranges:
            l, h = r

            if l <= e <= h:
                return True
            
        return False
    
fresh = 0

with open('inputs/5.input', 'r') as f:
    ranges, ids = [data.strip().split('\n') for data in f.read().split('\n\n')]

id_range = ID_range()

for r in ranges:
    lower, higher = r.split('-')
    id_range.append((int(lower), int(higher)))

for r in id_range.ranges:
    l1, h1 = r
    fresh += h1 - l1 + 1

print(fresh)