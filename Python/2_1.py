with open('./inputs/2.input', 'r') as f:
    ids = f.read().strip().split(',')

ids = [id.split('-') for id in ids]

invalid = []

def find_invalid_ids(lower, higher):
    invalids = []
    

    if lower // 10 == higher // 10 and lower // 10 % 2 == 0:
        return invalids
    
    for n in range(lower, higher):
        if str(n)[:len(str(n)) // 2] == str(n)[len(str(n)) // 2:]:
            invalids.append(n)

    return invalids
    
for lower, higher in ids:
    invalid.append(find_invalid_ids(int(lower), int(higher)))

print(sum([sum(entry) for entry in invalid]))