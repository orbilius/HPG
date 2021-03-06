#!/usr/bin/perl -w


local $/ = undef;

$in = <STDIN>;



#$in =~ s/<a href=\"\/statistik\/objekt\/(\d+).*?<\/td>/&printString("_id", "hemnet_".$1, "true", "false")/smge;
#$in =~ s/<td class=\"information\">.*?<a href=\"(\/beskrivning[^"]+)[^>]+>.*?<\/a>.*?<\/td>/&printString("url", $1, "false", "true")/smge;
#$in =~ s/<td class=\"kommun\">(\n|\s)*<a href=\"\/beskrivning[^>]+>(.*?)<\/a>.*?<\/td>/&printString("kommun", $2, "false", "false")/smge;


#$in =~ s/<td class=\"bostadstyp\">.*?<a href=\"\/beskrivning[^>]+>(.*?)<\/a>.*?<\/td>/&printString("type", $1, "false", "false")/smge;
#$in =~ s/<td class=\"avgift\">.*?<a href=\"\/beskrivning[^>]+>(.*?)<\/a>.*?<\/td>/&printNumber("fee", $1, "false", "false")/smge;
#$in =~ s/<td class=\"omrade\">.*?<a href=\"\/beskrivning[^>]+>(.*?)<\/a>.*?<\/td>/&printString("hood", $1, "false", "false")/smge;
#$in =~ s/<td class=\"adress\">.*?<a href=\"\/beskrivning[^>]+>(.*?)<\/a>.*?<\/td>/&printString("address", $1, "false", "false")/smge;
#$in =~ s/<td class=\"rum\">.*?<a href=\"\/beskrivning[^>]+>(.*?)<\/a>.*?<\/td>/&printNumber("rooms", $1, "false", "false")/smge;
#$in =~ s/<ul class=\"sizes\">.*?<li class=\"living-area\">.*?<a href=\"\[^>]+>(.*?)<\/a>/&printNumber("squareMeters", $1, "true", "true")/smge;
#$in =~ s/<td class=\"tomtarea\">.*?<a href=\"\/beskrivning[^>]+>(.*?)<\/a>.*?<\/td>/&printNumber("lotarea", $1, "false", "false")/smge;
#$in =~ s/<td class=\"pris\">.*?<a href=\"\/beskrivning[^>]+>(.*?)<\/a>.*?<\/td>/&printNumber("startPrice", $1, "false", "false")/smge;
$in =~ s/<ul class=\"prices\">.*?<li class=\"price\">.*?<a href=[^>]+>(.*?)<\/a>/&printNumber("startPrice", $1, "true", "false")/smge;
$in =~ s/<ul class=\"sizes\">.*?<li class=\"living-area\">.*?<a href=[^>]+>(.*?)<\/a>/&printNumber("squareMeters", $1, "false", "false")/smge;
$in =~ s/<li class=\"land-area\">.*?<a href=[^>]+>(.*?)<\/a>/&printNumber("lotArea", $1, "false", "false")/smge;
$in =~ s/<li class=\"area\">.*?<a href=[^>]+>(.*?)<\/a>/&printString("hood", $1, "false", "false")/smge;
$in =~ s/<li class=\"address\">.*?<a href=[^>]+>(.*?)<\/a>/&printString("address", $1, "false", "false")/smge;
$in =~ s/<li class=\"fee\">.*?<a href=[^>]+>(.*?)<\/a>/&printNumber("fee", $1, "false", "false")/smge;
$in =~ s/<li class=\"item-type\">.*?<a href=[^>]+>(.*?)<\/a>/&printString("type", $1, "false", "true")/smge;

$in =~ s/tempstring\s*\n\s*//smg;


#binmode(STDOUT, ":utf8");
print $in;

#open PLOGFILE, ">:utf8", ">parse/out/$ARGV[0].txt";
open PLOGFILE, ">parse/out/$ARGV[0].txt";
print PLOGFILE $in;
close PLOGFILE;


sub printString{
	$key=$_[0];
	$val=$_[1];
	$lead=&getLead($_[2]);
	$last=&getTail($_[3]);
	"$lead\"$key\":\"$val\"$tail";
}

sub printNumber{
	$key=$_[0];
	$val=$_[1];
	$lead=&getLead($_[2]);
	$last=&getTail($_[3]);
		 
	$val=~ s/[^0-9]//g;
	if($val eq ""){
		$val="0";
	}
		
	"$lead\"$key\":$val$tail";
	
}

sub getLead{
	
	$first=shift;
	$lead="";
	if($first eq "true"){
		$lead="{";
	} 
	
	$lead;	
}

sub getTail{
	$last=shift;	
	$tail="";
	if($last eq "true"){
		$tail="}";
	} else{
		$tail=",tempstring";
	}
}




