#!/usr/bin/perl


$numArgs = $#ARGV + 1;
#if($numArgs ne 2){
#	print "Usage: perl save.pl infile outfile\n";
#	exit;
#} else{
#	print $numArgs;
#}

#open (OBJFILE, $ARGV[0]) or die "Can't read that infile...\n";
#open (OUTFILE, ">$ARGV[1]") or die "Can't read that outfile...\n";

open LOGFILE, ">:utf8", ">clean/out/$ARGV[0].txt";


#binmode(STDOUT, ":utf8");
while ( $oline = <STDIN> ) {

	if($oline=~ m/\{[^}]+?\}/smg){
		#print (OUTFILE "$oline"); 	
		$trimmed=trim($oline);	
		print "$trimmed\n";
		print LOGFILE "$trimmed\n";
	}	
}

close LOGFILE;


sub trim{
	my $string = shift;
	$string =~ s/^[^{]+//;
	$string =~ s/^\s+//;
	$string =~ s/\s+$//;
#	$string =~ s/å/a/gi;
#	$string =~ s/ä/a/gi;
#	$string =~ s/ö/o/gi;
#	$string =~ s/Ä/A/gi;
#	$string =~ s/Å/A/gi;
#	$string =~ s/Ö/O/gi;	
	return $string;
}


#close (OUTFILE);
#close (OBJFILE);

#print "Done cleaning";

