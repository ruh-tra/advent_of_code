from math import log10, ceil

with open('2025/inputs/2.input', 'r') as f:
    ids = f.read().strip().split(',')

ids = [id.split('-') for id in ids]

invalid = []

def find_invalid_ids(lower, higher):
    invalids = []

    primes = set()

    for n in range(2, ceil(log10(higher) + 1)):
        if all(n % prime != 0 for prime in primes):
            primes.add(n)
    
    for n in range(lower, higher):
        for k in primes.intersection(range(ceil(log10(n)))):
                partition = int(k * str(n)[:ceil(log10(n)) // k])
               
                if partition == n:
                    invalids.append(partition)

    return invalids

for lower, higher in ids:
    invalid.append(find_invalid_ids(int(lower), int(higher)))

print(sum([sum(entry) for entry in invalid]))