import { SfeirThemeInitializer } from '../web_modules/sfeir-school-theme/sfeir-school-theme.mjs';

const speakers = [
  // comment speakers before presenting
  'TSI.md',
  'NDE.md',
  'Participant.md'
].map((trigram) => `00-school/speakers/${trigram}`);

// One method per module
function schoolSlides() {
  return ['00-school/00-TITLE.md', ...speakers, "00-school/01-objectives.md"];
}

function introSlides() {
  return ['00-school/00-TITLE.md\''];
}

function firstPartSlides(){
  return[
    '01-part1/01-Introduction.md',
    '01-part1/02-module-description.md',
    '01-part1/03-dev-mode.md',
    '01-part1/04-test-application.md',
    '01-part1/05-package-and-run-opt.md',
    '01-part1/06-database.md',
    '01-part1/07-crud-api.md',
    '01-part1/08-db-configuration.md',
    '01-part1/09-test-application.md',
  ]
}

function secondPartSlides(){
  return['02-part2/01-TITLE.md']
}

function thirdPartSlides(){
  return['03-part3-openapi/01-open-api.md']
}

function fourthPartSlides(){
  return['04-part4-BFF/01-bff.md']
}

function conclusion(){
  return['05-part5-conclusion/01-conclusion.md']
}

function bonusPartSlides(){
  return['09-part-bonus/01-TITLE.md']
}

function formation() {
  return [
    //
    ...schoolSlides(), //
    ...firstPartSlides(), //
    //...secondPartSlides(), //
    ...thirdPartSlides(), //
    ...fourthPartSlides(), //
    ...conclusion(), //
  ].map((slidePath) => {
    return { path: slidePath };
  });
}

SfeirThemeInitializer.init(formation);
