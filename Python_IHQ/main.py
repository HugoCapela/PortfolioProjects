import sys
import analyst_stats_script
import source_stats_script
import aux_functions

#def check_errors(sourceStats, analystStats):

# From command line arguments, get the name of the files
"""The Python sys module provides access to any command-line arguments via the sys.argv. This serves two purposes −

    sys.argv is the list of command-line arguments.

    len(sys.argv) is the number of command-line arguments.

Here sys.argv[0] is the program ie. script name."""
game_stats = sys.argv[1]
source_stats = sys.argv[2]

### Initialization of variables
first_line = ['       \t', 'G\t', 'A\t', 'PN\t', 'PIM\t', 'SOG\t', 'BLK\t', 'GV\t', 'HITS\n']
errors = ['ERRORS:', 0, 0, 0, 0, 0, 0, 0, 0]

# List of analyst and source stats from files
analyst_awayTeam = []
analyst_homeTeam = []
source_awayTeam = []
source_homeTeam = []

# List of analyst and source final stats to compare
analyst_final_away = []
analyst_final_home = []
source_final_away = []
source_final_home = []

# Step 1: Get analyst stats from file
analyst_stats_script.read_analyst_stats(game_stats, analyst_awayTeam, analyst_homeTeam)

# Step 2: Get source stats from file
source_stats_script.read_source_stats(source_stats, source_awayTeam, source_homeTeam)

# Step 3: Get analyst final stats
aux_functions.final_stats(analyst_awayTeam, analyst_final_away)
aux_functions.final_stats(analyst_homeTeam, analyst_final_home)

# Step 4: Get source final stats
aux_functions.final_stats(source_awayTeam, source_final_away)
aux_functions.final_stats(source_homeTeam, source_final_home)

# Step 5: Compare stats, count the differences
#
# For each player in source list:
# 1. Search for the player and return its index in the analyst list or return None (doesn't exist in analyst list)
# 2. If the index is None, two things can happen:
#   2.1. The player had no stats in game, which means it will not appear on the analyst list and it's stats on the source should be all zero = NO ERRORS
#   2.2. The analyst has errors in its data and this player has in game stats that should be counted = ERRORS EXIST
#   2.3. For both cases, just add the stats from the source list into the errors list
# 3. With the index of the current source_player, calculate the possible differences in the stats from the source with the analyst


for source_player in source_final_away:

    ind = aux_functions.search_player(source_player, analyst_final_away)

    if ind is None:
        aux_functions.direct_from_source(source_player, errors)
        continue

    aux_functions.calculate_dif_stats(source_player, analyst_final_away[ind], errors)

for source_player in source_final_home:

    ind = aux_functions.search_player(source_player, analyst_final_home)

    if ind is None:
        aux_functions.direct_from_source(source_player, errors)
        continue

    aux_functions.calculate_dif_stats(source_player, analyst_final_home[ind], errors)

# Step 6: Create and save in a new file the number of errors of this analyst

# Convert integers to strings and concatenate each element of the errors list with a tab space for readability on file
str_final_err = []
for i in range(len(errors)):
   s = str(errors[i]) + '\t'
   str_final_err.append(s)

# Build the name of the results file with the name of the analyst
file_name = game_stats[0:-4] + ' ERRORS.txt'

# Write on the file the results
with open(file_name, 'w') as file:

    data_to_write = ''.join(first_line)
    data_to_write += ''.join(str_final_err)
    #print(data_to_write)
    file.write(data_to_write)

    print('The file has been written')
