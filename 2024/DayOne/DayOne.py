f = open("input.txt", "r")

lines = f.readlines()

firstList = []
secondList = []

for line in lines:
    twoCharacters = line.split("   ")
    firstList.append(twoCharacters[0].strip())
    secondList.append(twoCharacters[1].strip())

firstList.sort()
secondList.sort()

print(firstList)
print(secondList)


differenceTotal = 0

for i in range(0,len(firstList),1):
    difference = abs(int(firstList[i]) * int(secondList.count(firstList[i])))
    differenceTotal = differenceTotal + difference

print(differenceTotal)


#time completixy is sorting plus n so n log n