import { PreschoolfrontPage } from './app.po';

describe('preschoolfront App', () => {
  let page: PreschoolfrontPage;

  beforeEach(() => {
    page = new PreschoolfrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
