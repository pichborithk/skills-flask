import { FaArrowRight } from 'react-icons/fa';
import PodcastCard from './PodcastCard';

const Podcasts = () => {
  return (
    <div>
      <div className='flex flex-col items-start gap-2 px-2 py-4 shadow-2xl'>
        <div className='flex items-center gap-2'>
          <h3>Podcasts</h3>
          <FaArrowRight />
        </div>
        <PodcastCard />
        <PodcastCard />
        <PodcastCard />
        <PodcastCard />
        <PodcastCard />
      </div>
    </div>
  );
};

export default Podcasts;
