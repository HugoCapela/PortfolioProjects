def read_analyst_stats(analyst_stats_file, analyst_away, analyst_home):

    # opening the file in read mode
    myFile = open(analyst_stats_file, "r")

    # reading the file
    data = myFile.read()

    # closing the file
    myFile.close()

    # replacing end splitting the text when newline ('\n') is seen
    dataIntoList = data.split("\n")
    #print(dataIntoList)
    #print(len(dataIntoList))

    # the file will start with "SKATER STATS " or "TEAM  G  A  PN  PIM  ..." has the first line.
    # If it starts with "SKATER STATS ", delete the first two lines
    # if it doesn't start with "SKATER STATS " it's because it starts with "TEAM G A PN PIM  ..." so delete just the first line
    if dataIntoList[0] == "SKATER STATS ":
        del dataIntoList[0:2]
    else:
        del dataIntoList[0]

    # the file will probably have a blank line at the end. Verify if it has and delete it
    if dataIntoList[-1] == "":
        del dataIntoList[-1]
        #print(len(dataIntoList))

    # data list to start work with
    #print(dataIntoList)

    isAway = True
    lineToSkip = False
    #awayTeam = []
    #homeTeam = []

    for line in dataIntoList:
        if lineToSkip:
            lineToSkip = False
            continue

        if line.startswith("TOTAL"):
            isAway = False
            lineToSkip = True
            continue
        
        #print("Line: " + line)

        playerStats = line.split("  ")
        #print("PlayerStats: ", playerStats)

        s = playerStats[0].upper()
        playerStats[0] = s

        # some indexes have to be deleted, they are not needed
        # the indexes are 1, 6, 10 and -1 (empty string)
        del playerStats[-1]
        del playerStats[10]
        del playerStats[6]
        del playerStats[1]

        print("playerStats: ", playerStats)

        if isAway:
            analyst_away.append(playerStats)
            continue

        analyst_home.append(playerStats)

