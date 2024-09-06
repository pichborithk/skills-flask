import { FilterTag, Podcasts } from '../components';

const Courses = () => {
  return (
    <div className='section-min-height mx-auto grid max-w-7xl grid-cols-5 justify-between gap-8 py-40'>
      <FilterTag />
      <Podcasts />
    </div>
  );
};

export default Courses;
