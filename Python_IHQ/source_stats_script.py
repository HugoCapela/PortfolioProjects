def read_source_stats(source_stats_file, source_away, source_home):

    # opening the file in read mode
    myFile = open(source_stats_file, "r")

    # reading the file
    data = myFile.read()

    # closing the file
    myFile.close()

    # replacing end splitting the text when newline ('\n') is seen
    dataIntoList = data.split("\n")
    #print(dataIntoList)
    #print(len(dataIntoList))

    # the file will start with "TEAM SUMMARY" or "TEAM  G   A   ..." has the first line.
    # the line "TOT 	SHF 	AVG 	PP 	SH 	EV" is to be deleted
    # If it starts with "TEAM SUMMARY", delete the first two lines
    # if it doesn't start with "TEAM SUMMARY" it's because it starts with "TEAM  G   A   ..."" so delete just the first line
    if dataIntoList[0] == "TEAM SUMMARY":
        del dataIntoList[0:2]
    else:
        del dataIntoList[0]

    # if the file has a blank line at the end, detect it and delete it
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
        if line.startswith("TOT"):
            lineToSkip = False
            continue

        if line.startswith("TEAM TOTALS"):
            isAway = False
            lineToSkip = True
            continue

        if lineToSkip:
            continue

        # split the line
        playerStats = line.split(" \t")

        # concat the player number with player name
        playerInfo = playerStats[0] + "-" + playerStats[2]
        
        # modify the list to replace empty stats with the number 0
        playerStatsMod = [str.replace(" ", "0") for str in playerStats]

        # build the list of stats to be used
        statsToAdd = [playerInfo, playerStatsMod[3], playerStatsMod[4], playerStatsMod[7], playerStatsMod[8], playerStatsMod[15], playerStatsMod[21], playerStatsMod[19], playerStatsMod[18]]
        
        #print("statsToAdd: ", statsToAdd)

        if isAway:
            source_away.append(statsToAdd)
            continue

        source_home.append(statsToAdd)
