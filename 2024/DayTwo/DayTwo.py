f = open("input.txt", "r")

lines = f.readlines()

safeCount = 0

for line in lines:
    levels = line.split()
    print()

    safe = True

    firstTime = True
    for i in range(0,len(levels)-1,1):
        levelDifference = int(levels[i].strip())-int(levels[i+1].strip())
        print(levelDifference)

        if not firstTime:
            if levelDifference < 0 and not negative:
                print("unsafe had a negative when the rest were positive")
                safe = False
                break
            elif levelDifference > 0 and negative:
                print("unsafe had a positive when the rest were negative")
                safe = False
                break

        if firstTime:
            if levelDifference < 0:
                negative = True
            else:
                negative = False

            firstTime = False
        
        if abs(levelDifference) > 3:
            print("unsafe too large")
            safe = False
            break

        if abs(levelDifference) < 1:
            print("unsafe too small")
            safe = False
            break


    if safe == True:
        safeCount+=1

print()
print(safeCount)