import sys
import analyst_stats_script
import source_stats_script

# Auxiliary functions
def final_stats(initialStats, finalStats):

    for player in initialStats:

        stats = [player[0], int(player[1]), int(player[2]), int(player[3]), int(player[4]), int(player[5]), int(player[6]), int(player[7]), int(player[8])]

        finalStats.append(stats)

#def check_errors(sourceStats, analystStats):


# Initialization of variables
g_err, a_err, pn_err, pim_err, sog_err, blk_err, hit_err, give_err = 0


# From command line arguments, get the name of the files
"""The Python sys module provides access to any command-line arguments via the sys.argv. This serves two purposes −

    sys.argv is the list of command-line arguments.

    len(sys.argv) is the number of command-line arguments.

Here sys.argv[0] is the program ie. script name."""
game_stats = sys.argv[1]
source_stats = sys.argv[2]

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
final_stats(analyst_awayTeam, analyst_final_away)
final_stats(analyst_homeTeam, analyst_final_home)

# Step 4: Get source final stats
final_stats(source_awayTeam, source_final_away)
final_stats(source_homeTeam, source_final_home)

# Step 5: Compare stats, count the differences and save a new file with the number of errors
check_errors(source_final_away, analyst_final_away)
check_errors(source_final_home, analyst_final_home)