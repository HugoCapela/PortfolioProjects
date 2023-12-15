# Auxiliary functions

# Function to convert stats as String to stats as Int
def final_stats(initialStats, finalStats):

    for player in initialStats:

        stats = [player[0], int(player[1]), int(player[2]), int(player[3]), int(player[4]), int(player[5]), int(player[6]), int(player[7]), int(player[8])]

        finalStats.append(stats)


# Funtion to search for a player in the analyst list and return it's index
def search_player(player, analyst_list):

    for index, element in enumerate(analyst_list):
        if element[0] == player[0]:
            return index
    
    return None

# Function to add directly from the source to the errors list
def direct_from_source(source_player, errors_list):
    for i in range(1, len(source_player)):
        sum = errors_list[i] + source_player[i]
        errors_list[i] = sum

# Function to compare stats and log the errors
def calculate_dif_stats(source_player, analyst_player, errors_list):
    for i in range(1, len(source_player)):
        #print('source_player', source_player, 'analyst_player', analyst_player)
        sum = abs(source_player[i] - analyst_player[i])
        #print(sum)
        errors_list[i] += sum
        #print(errors_list[i])

