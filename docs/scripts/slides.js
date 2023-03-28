import { SfeirThemeInitializer } from '../web_modules/sfeir-school-theme/sfeir-school-theme.mjs';

const speakers = [
  // comment speakers before presenting
  'TSI.md',
  'NDE.md',
  'Participant.md'
].map((trigram) => `00-school/speakers/${trigram}`);

// One method per module
function schoolSlides() {
  return ['00-school/00-TITLE.md', ...speakers];
}

function introSlides() {
  return ['intro/00-TITLE.md'];
}

function firstPartSlides(){
  return['01-part1/01-TITLE.md']
}

function secondPartSlides(){
  return['02-part2/01-TITLE.md']
}

function formation() {
  return [
    //
    ...schoolSlides(), //
    ...introSlides(), //
    ...firstPartSlides(), //
    ...secondPartSlides(), //
  ].map((slidePath) => {
    return { path: slidePath };
  });
}

SfeirThemeInitializer.init(formation);
