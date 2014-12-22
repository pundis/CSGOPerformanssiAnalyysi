Ensimmäiset testit testaavat ainoastaan profiili luokkaa ja kentän lisäämistä siihen sekä tietorakenteita.

Testejä alle 10 sillä rajapintoja tulee rajaamaan käyttöliittymä (Kartan voittavalla joukkueella 16 kierrosta, max yht 30).

Pit raporttia en saanut perille seuraavan errorin takia: 

Failed to execute goal org.pitest:pitest-maven:0.30:mutationCoverage (default-cli) on project CSGOPerformanssiAnalyysi: Execution default-cli of goal org.pitest:pitest-maven:0.30:mutationCoverage failed: No mutations found. This probably means there is an issue with either the supplied classpath or filters.
See http://pitest.org for more details.
-> [Help 1]

To see the full stack trace of the errors, re-run Maven with the -e switch.
Re-run Maven using the -X switch to enable full debug logging.

For more information about the errors and possible solutions, please read the following articles:
[Help 1] http://cwiki.apache.org/confluence/display/MAVEN/PluginExecutionException

