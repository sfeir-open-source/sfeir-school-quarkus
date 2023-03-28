import { SfeirThemeInitializer } from '../web_modules/sfeir-school-theme/sfeir-school-theme.mjs';

const speakers = [
  // comment speakers before presenting
  'TSI',
  'NDE'
].map((trigram) => `speakers/${trigram}`);

// One method per module
function schoolSlides() {
  return ['00-school/00-TITLE.md', '00-school/speakers/speaker-jef.md'];
}

function introSlides() {
  return ['intro/00-TITLE.md'];
}

function formation() {
  return [
    //
    ...schoolSlides(), //
    ...introSlides(), //
  ].map((slidePath) => {
    return { path: slidePath };
  });
}

SfeirThemeInitializer.init(formation);
